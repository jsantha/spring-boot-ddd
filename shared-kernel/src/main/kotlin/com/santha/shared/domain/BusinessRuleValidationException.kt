package com.santha.shared.domain

class BusinessRuleValidationException(rule: BusinessRule) : Exception(rule.message) {
}
