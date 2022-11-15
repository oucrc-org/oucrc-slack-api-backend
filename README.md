# 概要

部のSlack botのバックエンド部分です
Slack APIと叩き合ったり、DBにデータを保存したりします

# 使い方

ここではUnixでの実行時のコマンドを記述します

Windowsユーザーの場合は`gradlew`の代わりに`gradlew.bat`を利用してください

実行するとき
```shell
./gradlew run
```

コードフォーマッターを実行する
```shell
# コードが正しくフォーマットできてるか確認する
./gradlew ktlintCheck

# コードを勝手に整形する
./gradlew ktlintFormat
```

テストを実行する
```shell
./gradlew test
```

# 命名規則

[Kotlin Cording Conversion](https://kotlinlang.org/docs/coding-conventions.html#class-headers) に従うものとする

