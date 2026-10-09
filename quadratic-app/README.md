# quadratic-app

Ứng dụng console dùng thư viện `quadratic-lib.jar` (trong thư mục `lib/`).

```
mvn clean package
java "-Dfile.encoding=UTF-8" -cp "target/classes;lib/quadratic-lib.jar" com.codegym.Main
java "-Dfile.encoding=UTF-8" -cp "target/classes;lib/quadratic-lib.jar" com.codegym.Main 1 -3 2
```
(macOS/Linux dùng dấu `:` thay cho `;` trong classpath)
