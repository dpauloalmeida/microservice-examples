package com.example.rentalcar.filter

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest


@Component
class PostFilter(
    private val discoveryClient: DiscoveryClient
) : ZuulFilter() {

    companion object {
        private const val REQUEST_PATH = "/inventories"
        private const val TARGET_SERVICE = "inventory-query"
        private const val HTTP_METHOD = "GET"
    }

    override fun filterType() = FilterConstants.ROUTE_TYPE

    override fun filterOrder() = 0

    override fun shouldFilter(): Boolean {
        val context: RequestContext = RequestContext.getCurrentContext()
        val request: HttpServletRequest = context.request
        val method = request.method
        val requestURI = request.requestURI
        return HTTP_METHOD == method && requestURI.startsWith(REQUEST_PATH)
    }

    override fun run(): Any? {
        val context = RequestContext.getCurrentContext()
        val instances = discoveryClient.getInstances(TARGET_SERVICE)

        try {
            if (instances.isNotEmpty()) {
                context.routeHost = instances[0].uri.toURL()
            } else {
                throw IllegalStateException("Target service instance not found!")
            }
        } catch (e: Exception) {
            throw IllegalArgumentException("Couldn't get service URL!", e)
        }

        return null
    }
}