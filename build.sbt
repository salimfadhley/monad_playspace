name := "monad_playspace"

version := "1.0"

scalaVersion := "2.12.1"
val monocleVersion = "1.4.0"

resolvers += "twitter" at "http://maven.twttr.com"

libraryDependencies ++= Seq(
  "eu.timepit" %% "refined"            % "0.8.0",
  "eu.timepit" %% "refined-pureconfig" % "0.8.0",  // optional, JVM-only
  "eu.timepit" %% "refined-scalacheck" % "0.8.0", // optional
  "eu.timepit" %% "refined-scalaz"     % "0.8.0", // optional
  "eu.timepit" %% "refined-scodec"     % "0.8.0", // optional
  "org.typelevel" %% "cats" % "0.9.0",
  "com.typesafe.akka" %% "akka-actor" % "2.5.0",
  "com.github.julien-truffaut" %%  "monocle-core"  % monocleVersion,
  "com.github.julien-truffaut" %%  "monocle-macro" % monocleVersion,
  "com.github.julien-truffaut" %%  "monocle-law"   % monocleVersion % "test"
)
