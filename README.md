# Hoyoverse Java API

[![jitpack](https://img.shields.io/jitpack/version/com.github.zvyap/Hoyoverse-API?color=blue)](https://jitpack.io/#zvyap/Hoyoverse-API)
[![jitpack](https://img.shields.io/badge/Snapshots-JitPack-blue)](https://jitpack.io/#zvyap/Hoyoverse-API/master-SNAPSHOT)

A Java library for Hoyoverse API

## Game supported
* Genshin Impact
* Honkai Impact 3RD
* Honkai: Star Rail
* Tears of Themis

### **Oversea & China's server** ***supported***
> [!NOTE]
> Some features may not be available in China's server due to I did not have a actual China MYS account to test it

## Features
* Daily check in
* Get game character basic information (uid, level, etc)
* Get others/self forum user data
* Get self accounting data
* Multiple user support without recreating the main instance
* MultiInstance of the library

## Work In Progress Features
* Get information - resin, teapot, daily, opened chest, etc
* Get game content details information (weapon, artifact, charactor, etc)
* Battle Chronicle with abyss, TCG data support

## Requirements
* Java 11 or newer

## How to use
Add this project as your dependency, for more version or usage, check out - [JitPack](https://jitpack.io/#zvyap/Hoyoverse-API/)
<br>
For those who want use newest commit as your version, use ```master-SNAPSHOT``` as the project version

### Gradle - Groovy
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.zvyap:Hoyoverse-API:[VERSION]'
}
```

### Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>com.github.zvyap</groupId>
    <artifactId>Hoyoverse-API</artifactId>
    <version>[VERSION]</version>
  </dependency>
</dependencies>
```


---

## Build yourself
```
gradlew build
```
The jar file will spawn at **./build/libs/**