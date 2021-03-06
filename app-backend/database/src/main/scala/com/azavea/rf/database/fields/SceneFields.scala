package com.azavea.rf.database.fields

import java.util.UUID

import com.azavea.rf.database.ExtendedPostgresDriver.api._
import com.azavea.rf.datamodel.{JobStatus, IngestStatus}
import geotrellis.slick.Projected
import geotrellis.vector.MultiPolygon

import io.circe.Json

trait SceneFields  { self: Table[_] =>
  def id: Rep[UUID]
  def name: Rep[String]
  def createdAt: Rep[java.sql.Timestamp]
  def datasource: Rep[UUID]
  def sceneMetadata: Rep[Json]
  def cloudCover: Rep[Option[Float]]
  def acquisitionDate: Rep[Option[java.sql.Timestamp]]
  def thumbnailStatus: Rep[JobStatus]
  def boundaryStatus: Rep[JobStatus]
  def sunAzimuth: Rep[Option[Float]]
  def sunElevation: Rep[Option[Float]]
  def tileFootprint: Rep[Option[Projected[MultiPolygon]]]
  def dataFootprint: Rep[Option[Projected[MultiPolygon]]]
  def ingestLocation: Rep[Option[String]]
  def ingestStatus: Rep[IngestStatus]
}
