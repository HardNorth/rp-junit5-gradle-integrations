/*
 * Copyright 2020 EPAM Systems
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.epam.reportportal.example.junit5.step;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class NestedStepsWithDynamicTests {
	@TestFactory
	Stream<DynamicTest> testDynamicTests() {
		return Stream.of(
				dynamicTest("Test one", () -> new TestNumbers(1, "one").testNumberConversion()),
				dynamicTest("Test two", () -> new TestNumbers(2, "two").testNumberConversion()),
				dynamicTest("Test three", () -> new TestNumbers(3, "three").testNumberConversion()),
				dynamicTest("Test four", () -> new TestNumbers(4, "four").testNumberConversion()),
				dynamicTest("Test five", () -> new TestNumbers(5, "five").testNumberConversion()),
				dynamicTest("Test six", () -> new TestNumbers(6, "six").testNumberConversion()),
				dynamicTest("Test seven", () -> new TestNumbers(7, "seven").testNumberConversion()),
				dynamicTest("Test eight", () -> new TestNumbers(8, "eight").testNumberConversion())
		);
	}
}
