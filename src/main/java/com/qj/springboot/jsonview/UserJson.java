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

	@JsonView(View.Public.class)
	private Long id;

	@JsonView(Name.class)
	private String firstname;

	@JsonView(Name.class)
	private String lastname;

	private String email;
	@JsonView(Address.class)
	private String address;
	private String postalCode;
	private String city;
	private String country;

	/**
	 * 视图
	 */
	public interface Name extends View.Public{}
	public interface Address extends View.Public{}
	public interface User extends Name,Address{}
}
