package com.santha.shared.domain

import java.io.Serializable

abstract class StronglyTypedId<T>(val value: T) : Serializable
