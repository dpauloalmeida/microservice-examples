package com.example.rentalcar.config

import com.netflix.zuul.context.RequestContext
import org.springframework.cloud.netflix.zuul.filters.post.LocationRewriteFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus

@Configuration
class LocationRewriteConfig {

    @Bean
    fun locationRewriteFilter(): LocationRewriteFilter {
        return object : LocationRewriteFilter() {
            override fun shouldFilter(): Boolean {
                val statusCode = RequestContext.getCurrentContext().responseStatusCode
                return HttpStatus.valueOf(statusCode).is3xxRedirection
                        || HttpStatus.valueOf(statusCode).is2xxSuccessful
            }
        }
    }
}