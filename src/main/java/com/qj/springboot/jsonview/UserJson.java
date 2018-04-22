/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.qj.springboot.jsonview;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@Data
public class UserJson {

	@JsonView(View.Common.class)
	private Long id;

	@JsonView(View.Ext.class)
	private String firstname;

	@JsonView(View.Deal.class)
	private String lastname;

	private String email;
	private String address;
	private String postalCode;
	private String city;
	private String country;
}
