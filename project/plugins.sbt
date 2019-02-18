logLevel := Level.Info

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.18")
addSbtPlugin("com.geirsson"     % "sbt-scalafmt"        % "1.5.1")

//enablePlugins(GraalVMNativeImagePlugin)