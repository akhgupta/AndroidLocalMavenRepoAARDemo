#### This project demonstrates How we can improve Android build times & have better Android Studio performance using local maven repository approach.

#### Recommended for projects where we have more than one module.

<br><br>

## How to run this demo ?

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
2. Open `gradle/local-aar-config.gradle` and specify modules on which you want to work in array `ext.inDevModules`. e.g.

  ```
  ext.inDevModules = [
                 ":app",
                 ":myawesomemodule1"
                 ]
  ```

3. Do gradle sync

4. Once sync is complete, check Android View of project.

5. That's it, you can try adding / removing modules names and syncing same.

<br><br>

## How to integrate this approach in your app ?

1. Specify local maven repo in your project root level `build.gradle`

  ```
  maven {   url = "$rootDir/localMavenRepository"   }
  ```

2. Add below files to root level `gradle` directory

  ```
  gradle/local-aar.gradle
  gradle/local-aar-config.gradle
  gradle/publish.gradle
  ```

3. In your `settings.gradle`, add below

  ```groovy
  apply from: "$rootDir/gradle/local-aar.gradle"
  ```

4. In your `settings.gradle`, replace included modules entries like this for all modules. e.g. replace

  ```groovy
  include ':awesomeModule1'
  ```

  with

  ```groovy
  includeIfEnabled(':awesomeModule1')
  ```

5. In your **app** modules `build.gradle` files, add below

  ```groovy
  apply from: "$rootDir/gradle/local-aar.gradle"
  ```

6. In your **library** modules `build.gradle` files, add below

  ```groovy
  apply from: "$rootDir/gradle/local-aar.gradle"
  apply from: "$rootDir/gradle/publish.gradle"
  ```

7. Specify your dependencies path using `customModulePath` method in your `build.gradle` files. e.g. replace

  ```groovy
  implementation project(path: ':myawesomemodule1')
  ```

   with

  ```groovy
  implementation(customModulePath('myawesomemodule1'))
  ```

8. Add `/localMavenRepository` in your `.gitignore`
9. Follow **How to run this demo section** for building with this approach.
