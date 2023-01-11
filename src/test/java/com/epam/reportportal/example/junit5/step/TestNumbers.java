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

import com.epam.reportportal.annotations.Step;
import com.ibm.icu.text.RuleBasedNumberFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestNumbers {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestNumbers.class);

	private final int number;
	private String actualResult;
	private final String expectedResult;

	public TestNumbers(int num, String numWord) {
		number = num;
		expectedResult = numWord;
	}

	@Step("Log test values")
	public void log() {
		LOGGER.info("Number: " + number + "; expected result: " + expectedResult);
		LOGGER.info("Current thread: " + Thread.currentThread().getName());
	}

	@Step("Format an integer into spelled number")
	public void formatNumber() {
		Locale locale = Locale.US;
		LOGGER.debug("Formatting a number using locale: " + locale.toString());
		RuleBasedNumberFormat formatter = new RuleBasedNumberFormat(locale, RuleBasedNumberFormat.SPELLOUT);
		actualResult = formatter.format(number, "%spellout-numbering");
	}

	@Step("Validate the results")
	public void validate() {
		LOGGER.debug("Comparing actual result: " + actualResult + "; with expected result: " + expectedResult);
		assertThat(actualResult, equalTo(expectedResult));
	}

	public void testNumberConversion() {
		log();
		formatNumber();
		validate();
	}
}
