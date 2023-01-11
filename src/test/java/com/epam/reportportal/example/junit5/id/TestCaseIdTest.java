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

package com.epam.reportportal.example.junit5.id;

import com.epam.reportportal.annotations.TestCaseId;
import com.epam.reportportal.annotations.TestCaseIdKey;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@SuppressWarnings("unused")
public class TestCaseIdTest {

	@TestCaseId("TNG.1.0.1")
	@Test
	public void simpleTest() {
		Assertions.assertEquals(1, 1);
	}

	public static Object[][] data() {
		return new Object[][] { { "TNG.1.0", 2, 2 }, { "TNG.1.1", 6, 6 }, { "TNG.1.2", 19, 20 } };
	}

	@TestCaseId(parametrized = true)
	@ParameterizedTest
	@MethodSource("data")
	public void parametrizedTestWithKey(@TestCaseIdKey String testCaseId, Integer expected, Integer evaluated) {
		Assertions.assertEquals(expected, evaluated);
	}

	@ParameterizedTest
	@MethodSource("data")
	public void parametrizedTestWithoutKey(String testCaseId, Integer expected, Integer evaluated) {
		Assertions.assertEquals(expected, evaluated);
	}
}
