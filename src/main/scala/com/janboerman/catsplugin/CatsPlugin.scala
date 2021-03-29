package com.janboerman.catsplugin

import cats._
import cats.data._
import cats.implicits._

import me.bristermitten.pdm.{SpigotDependencyManager}

import xyz.janboerman.scalaloader.plugin.{ScalaPlugin, ScalaPluginDescription}
import xyz.janboerman.scalaloader.plugin.description.{Scala, ScalaVersion}

@Scala(version = ScalaVersion.v2_13_5)
object CatsPlugin extends ScalaPlugin(new ScalaPluginDescription("CatsPlugin", "1.0")) {

    private val pluginDependencyManager = SpigotDependencyManager.of(this)
    private val completableFuture = pluginDependencyManager.loadAllDependencies()

    override def onEnable(): Unit = {

        completableFuture.thenRunAsync(() => {

            val optionString = "Hello, Cats!".some
            getLogger.info(s"$optionString")

        }, runnable => getServer.getScheduler.runTask(this, runnable))
    }



}