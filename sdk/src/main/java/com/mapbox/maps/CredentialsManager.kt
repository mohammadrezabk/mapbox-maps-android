package com.mapbox.maps

import android.content.Context

data class CredentialsManager(val accessToken: String? = null) {
  fun getAccessToken(context: Context): String {
    return accessToken ?: context.run {
      val tokenResId = resources.getIdentifier(
        MAPBOX_ACCESS_TOKEN_RESOURCE_NAME,
        "string",
        packageName
      )
      if (tokenResId != 0) getString(tokenResId) else ""
    }
  }

  companion object {
    var shared: CredentialsManager = CredentialsManager()
  }
}