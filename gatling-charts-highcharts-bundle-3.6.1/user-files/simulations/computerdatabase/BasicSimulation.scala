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

class BasicSimulation extends Simulation {

  val httpProtocol = http
    // Here is the root for all relative URLs
    .baseUrl("http://localhost:8081")
    .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyLCJzY29wZSI6ImRlbW9Vc2VyIn0.Qn8WJgydIevB_9ALP21vSKewi5YHUHp11FMizhAq104")

  // A scenario is a chain of requests and pauses
  val scn = scenario("Scenario Name").repeat(100, "n") {
    exec(
      http("request_1")
        .get("/authenticated-route")
    ).pause(0.1 seconds)
      // Note that Gatling has recorded real time pauses
      .exec(
        http("request_2")
          .get("/authors")
      ).pause(0.1 seconds)
  }

  setUp(scn.inject(atOnceUsers(300)).protocols(httpProtocol))
}