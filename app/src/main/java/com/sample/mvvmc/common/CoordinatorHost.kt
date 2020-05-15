package com.sample.mvvmc.common

import com.sample.mvvmc.common.Coordinator

interface CoordinatorHost {
    val coordinator: Coordinator<*>
}
