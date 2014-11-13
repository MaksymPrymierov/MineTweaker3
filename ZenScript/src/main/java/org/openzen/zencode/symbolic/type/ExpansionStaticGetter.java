/*
 * This file is part of MineTweaker API, licensed under the MIT License (MIT).
 * 
 * Copyright (c) 2014 MineTweaker <http://minetweaker3.powerofbytes.com>
 */
package org.openzen.zencode.symbolic.type;

import org.openzen.zencode.symbolic.scope.IScopeMethod;
import org.openzen.zencode.symbolic.expression.IPartialExpression;
import stanhebben.zenscript.type.ZenType;
import org.openzen.zencode.symbolic.MemberStatic;
import org.openzen.zencode.symbolic.member.IGetter;
import org.openzen.zencode.symbolic.method.IMethod;
import org.openzen.zencode.util.CodePosition;

/**
 *
 * @author Stan
 */
public class ExpansionStaticGetter implements IGetter
{
	private final MemberStatic member;
	private final IMethod method;
	
	public ExpansionStaticGetter(MemberStatic member, IMethod method)
	{
		this.member = member;
		this.method = method;
	}

	@Override
	public ZenType getType()
	{
		return method.getReturnType();
	}

	@Override
	public IPartialExpression compileGet(CodePosition position, IScopeMethod scope)
	{
		return method.callStatic(position, scope);
	}
}