# Build quadratic-lib -> copy jar sang quadratic-app/lib -> build và chạy quadratic-app
$ErrorActionPreference = "Stop"
$root = $PSScriptRoot

Write-Host "=== 1. Build quadratic-lib ===" -ForegroundColor Cyan
Push-Location "$root\quadratic-lib"
mvn clean package
if ($LASTEXITCODE -ne 0) { Pop-Location; throw "Build quadratic-lib that bai" }
Pop-Location

Write-Host "=== 2. Copy jar sang quadratic-app\lib ===" -ForegroundColor Cyan
Copy-Item "$root\quadratic-lib\target\quadratic-lib-1.0-SNAPSHOT.jar" "$root\quadratic-app\lib\quadratic-lib.jar" -Force

Write-Host "=== 3. Build quadratic-app ===" -ForegroundColor Cyan
Push-Location "$root\quadratic-app"
mvn clean package
if ($LASTEXITCODE -ne 0) { Pop-Location; throw "Build quadratic-app that bai" }

Write-Host "=== 4. Chay thu 3 truong hop ===" -ForegroundColor Cyan
chcp 65001 | Out-Null
foreach ($testCase in @(@("1","-3","2"), @("1","2","1"), @("1","1","1"), @("0","2","1"))) {
    Write-Host ""
    java "-Dfile.encoding=UTF-8" -cp "target/classes;lib/quadratic-lib.jar" com.codegym.Main $testCase[0] $testCase[1] $testCase[2]
}
Pop-Location
