# 概要

全モジュールにて利用されるソースコードを格納するための場所
基本的に利用するべきではない（全部のソースコードがここに入りだすと無法地帯と化すため）

# 入っているソースコード

## ApiResult型

Result型のことで、プロジェクト内のエラーハンドリングの際に用いる

### 使用例

```kotlin
fun foo(): ApiResult<String, IOException> = try {
    ApiResult.Success(readLine())
} catch (e: IOException) {
    ApiResult.Failure(e)
}

val input = foo()
    .map { string -> string.replace(",") }
    .mapBoth(
        success = { println("Success: $it") },
        failure = { println("Error") }
    )


/**
 * input -> I a,m T,o,m.
 * output -> I am Tom.
 */
```

このように記述することで、以下の利点が期待できる
1. 関数の返り値を見ることで、その関数がどのようなエラーを投げるのかがわかる
2. 突然エラーが投げられて終了するということがなくなる
3. 必ずエラーハンドリングしないと値を見れなくできる
4. 他の関数との組み合わせが用意になる

注意：*Throwable* や *Exception* といった最上位のクラスを取らないようにする

### 仕組み

クラス定義は以下のようになっている

```kotlin
sealed class ApiResult<out T, out E> {
    data class Success<T>(val value: T) : ApiResult<T, Nothing>()
    data class Failure<E>(val value: E) : ApiResult<Nothing, E>()
}
```

これにより`ApiResult`型のインスタンスは`Success`か`Failure`のみになる

`Success`と`Failure`が持つ値の型はお互いに違うため、成功時には目的の値、
失敗時にはエラーとすることができる
