import com.egoriku.ext.withLibraries

plugins {
    id("HappyXPlugin")
    id("com.android.library")
}

withLibraries(
        Libs.appcompat,
        Libs.core,
        Libs.fragment
)