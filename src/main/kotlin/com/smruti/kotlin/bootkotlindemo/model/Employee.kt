package com.smruti.kotlin.bootkotlindemo.model

import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document

@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Document
data class Employee (@Id val id : Int = 0, val name : String? = null, val salary: Long = 0)