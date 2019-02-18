import Dependencies._


ThisBuild / scalaVersion := "2.12.8"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "poc-cli",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "info.picocli" % "picocli" % "3.9.3",
    libraryDependencies += "info.picocli" % "picocli-codegen" % "3.9.3",
  )

lazy val graalConfig = inputKey[Unit]("gen-graal-config")

graalVMNativeImageOptions += "-H:ReflectionConfigurationFiles=../demo.json"

graalConfig:= {
    (runMain in Compile).fullInput(" picocli.codegen.aot.graalvm.ReflectionConfigGenerator -o=target/demo.json example.Demo").evaluated
}

enablePlugins(GraalVMNativeImagePlugin)

