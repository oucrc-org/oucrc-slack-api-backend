@file:Suppress("NonAsciiCharacters", "TestFunctionName")

package net.oucrc

import com.google.common.truth.Truth.assertThat
import kotlin.test.Test
import kotlin.test.fail

class ApiResultMapTest {
    @Test
    fun 型がSuccessの時はラムダ式を実行して結果を返す() {
        val mockedMaybe = ApiResult.Success("mockedSuccess")
        val updatedMockedMaybe = mockedMaybe.map { "updatedSuccess" }

        val expected = ApiResult.Success("updatedSuccess")

        assertThat(updatedMockedMaybe).isEqualTo(expected)
    }

    @Test
    fun 型がFailureの時はそのままの結果を返す() {
        val mockedMaybe = ApiResult.Failure("mockedFailure")
        val updatedMockedMaybe = mockedMaybe.map { fail("mapの中身を実行") }

        val expected = ApiResult.Failure("mockedFailure")

        assertThat(updatedMockedMaybe).isEqualTo(expected)
    }
}
