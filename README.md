# Epsum Things Java SDK
EpsumThings Java SDK for developers and hobbyists alike for using EpsumThings IoT platform.

# Installation
For maven project you can install this package by adding following line in your POM File.. 
```
<dependency>
  <groupId>com.epsumlabs</groupId>
  <artifactId>EpsumThingsJavaSDK</artifactId>
  <version>0.0.1-beta</version>
  <type>pom</type>
</dependency>
```
For gradle you can use
```
compile 'com.epsumlabs:EpsumThingsJavaSDK:0.0.1-beta'
```
for  Ivy you can use
```
<dependency org='com.epsumlabs' name='EpsumThingsJavaSDK' rev='0.0.1-beta'>
  <artifact name='EpsumThingsJavaSDK' ext='pom' ></artifact>
</dependency>
```
# Example Code
```java
import com.epsumlabs.epsumthingsjavasdk.EpsumThings;

public static void main(String[] args)throws Exception
    {
        Account user=new Account("username", "secret_key", "app_id");
        System.out.print(EpsumThings.userProfile(user));
    } 
```

# About
EpsumThings (Beta) is an IoT platform developed at **Epsum Labs Private Limited** for people like you to taste the sweetness of IoT with minimal effort.

Get registered at http://things.epsumlabs.com to explore the IoT platform.

