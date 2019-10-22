#### This project demonstrates How we can improve Android build times & have better Android Studio performance using local maven repository approach.

#### Recommended for projects where we have more than one module.



<br><br>

# How to run this demo ?

<br>

### Publish local AAR artifacts

1. Build & publish AAR artifacts to local maven repository by using

  ```
  ./gradlew publishAarPublicationToMavenRepository -PuseAARForDevBuild=false
  ```

2. You should be able to see the folder name `localMavenRepository` in your root directory. As the name suggests, this is your local maven repository and you should be able to see all artifacts under it.

<br>

### Specify dev modules to work on

1. Add `useAARForDevBuild=true` in your `local.properties` (in your project's root directory)
2. Also specify modules on which you want to work, e.g. it should look like this

  ```
  useAARForDevBuild=true
  modules=:app :myawesomemodule1 :myawesomemodule2
  ```

3. Do gradle sync

4. Once sync is complete, check `Android View` of project in `Android Studio`

5. That's it, you can try adding / removing modules names and syncing same.

<br><br>
## Demo Video
https://www.youtube.com/watch?v=rNT9eS5pO-g
<br><br><br>

# How to integrate this approach in your app ?

1. Add below in your project root level `build.gradle`
```
apply from: "$rootDir/gradle/local-aar-config.gradle"
apply from: "$rootDir/gradle/local-aar.gradle"
```
2. Also, specify local maven repo in your project root level `build.gradle`

  ```
  maven {   url = "$rootDir/localMavenRepository"   }
  ```

3. Add below files to root level `gradle` directory

  ```
  gradle/local-aar.gradle
  gradle/local-aar-config.gradle
  gradle/publish.gradle
  ```

4. In your `settings.gradle`, add below

  ```groovy
  apply from: "$rootDir/gradle/local-aar.gradle"
  ```

5. In your `settings.gradle`, replace included modules entries like this for all modules. e.g. replace

  ```groovy
  include ':awesomeModule1'
  ```

  with

  ```groovy
  includeIfEnabled(':awesomeModule1')
  ```

6. In your **app** modules `build.gradle` files, add below

  ```groovy
  apply from: "$rootDir/gradle/local-aar.gradle"
  ```

7. In your **library** modules `build.gradle` files, add below

  ```groovy
  apply from: "$rootDir/gradle/local-aar.gradle"
  apply from: "$rootDir/gradle/publish.gradle"
  ```

8. Specify your dependencies path using `customModulePath` method in your `build.gradle` files. e.g. replace

  ```groovy
  implementation project(path: ':myawesomemodule1')
  ```

   with

  ```groovy
  implementation customModulePath(':myawesomemodule1')
  ```

9. Add `/localMavenRepository` in your `.gitignore`
10. Follow **How to run this demo section** for building with this approach.
