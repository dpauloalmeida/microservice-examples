package com.example.rentalcar.reservation

import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails
import org.springframework.stereotype.Component
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate

@Component
class CustomerClient(
    private val restTemplate: RestTemplate,
    private val discoveryClient: DiscoveryClient
) {

    companion object {
        private const val TARGET_SERVICE = "auth"
    }

    fun getCustomerDetail(username: String, authentication: Authentication): CustomerDetailResponse {
        val url: String

        val instances = discoveryClient.getInstances(TARGET_SERVICE)

        if (instances.isNotEmpty()) {
            url = "${instances[0].uri.toURL()}/users/$username"
        } else {
            throw IllegalStateException("Target service instance not found!")
        }

        val headers = HttpHeaders()

        val details = authentication.details as OAuth2AuthenticationDetails
        headers["Authorization"] = "Bearer ${details.tokenValue}"

        val request = HttpEntity<MultiValueMap<String, String>>(headers)

        val exchange = restTemplate.exchange(url, HttpMethod.GET, request, CustomerDetailResponse::class.java)

        return exchange.body ?: throw RuntimeException()
    }
}
