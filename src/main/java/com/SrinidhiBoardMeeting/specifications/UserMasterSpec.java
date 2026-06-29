package com.SrinidhiBoardMeeting.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.SrinidhiBoardMeeting.model.Users;

public class UserMasterSpec {

	public static Specification<Users> userNameLike(String userName) {
		return (root, query, builder) -> userName == null || userName == "" ? builder.conjunction()
				: builder.like(builder.lower(root.get("userName")), "%" + userName.toLowerCase() + "%");
	}

	public static Specification<Users> roleIdEqual(Long long1) {
		return (root, query, builder) -> long1 == null || long1 == 0 ? builder.conjunction()
				: builder.equal(root.get("roleId"), long1);
	}

}
