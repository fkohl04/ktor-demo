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

class PerformanceTest extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8084")

  val scn = scenario("Ktor performance test").exec(
      http("request_1")
        .get("/")
    )

  setUp(scn.inject(constantConcurrentUsers(1000).during(180.seconds)).protocols(httpProtocol))
}
