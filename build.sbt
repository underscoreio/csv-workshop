organization := "com.acme"
name         := "scala-csv"
version      := "0.1-SNAPSHOT"

// Stuff required by the existing code:
libraryDependencies ++= Seq(
  "com.bizo"      %% "mighty-csv"  % "0.2",
  "org.scalatest" %% "scalatest"   % "2.2.4" % Test
)

// Stuff that may come in useful:
libraryDependencies ++= Seq(
  "org.typelevel" %% "cats"        % "0.4.1",
  "org.scalaz"    %% "scalaz-core" % "7.2.0"
)
