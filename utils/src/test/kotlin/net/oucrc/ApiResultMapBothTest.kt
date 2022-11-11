@file:Suppress("NonAsciiCharacters", "TestFunctionName")

package net.oucrc

import com.google.common.truth.Truth.assertThat
import kotlin.test.Test
import kotlin.test.fail

class ApiResultMapBothTest {
    @Test
    fun 型がSuccessの時はsuccessを実行して結果を返す() {
        val mockedMaybe = ApiResult.Success("mockedSuccess")
        val updatedMockedMaybe = mockedMaybe.mapBoth(
            success = { "updatedSuccess" },
            failure = { fail("failureの方を実行") },
        )

        val expected = ApiResult.Success("updatedSuccess")

        assertThat(updatedMockedMaybe).isEqualTo(expected)
    }

    @Test
    fun 型がFailureの時はfailureを実行して結果を返す() {
        val mockedMaybe = ApiResult.Failure("mockedFailure")
        val updatedMockedMaybe = mockedMaybe.mapBoth(
            success = { fail("successの方を実行") },
            failure = { "updatedFailure" },
        )

        val expected = ApiResult.Failure("updatedFailure")

        assertThat(updatedMockedMaybe).isEqualTo(expected)
    }
}