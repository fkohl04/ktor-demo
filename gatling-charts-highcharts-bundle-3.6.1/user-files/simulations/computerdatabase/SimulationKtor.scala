/*
 * Copyright 2011-2021 GatlingCorp (https://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package computerdatabase

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SimulationKtor extends Simulation {

  val httpProtocol = http
    // Here is the root for all relative URLs
    .baseUrl("http://localhost:8082")
//    .baseUrl("https://murmuring-journey-64164.herokuapp.com")

  // A scenario is a chain of requests and pauses
  val scn = scenario("Scenario Name").pace(1.seconds).exec(
      http("request_1")
        .get("/")
    )

  setUp(scn.inject(constantConcurrentUsers(200).during(600.seconds)).protocols(httpProtocol))
}
