package org.openlegacy.providers.jt400.mockup;

import org.openlegacy.annotations.rpc.Direction;
import org.openlegacy.annotations.rpc.RpcField;
import org.openlegacy.rpc.RpcEntity;

@org.openlegacy.annotations.rpc.RpcEntity("/QSYS.LIB/TESTLIB.LIB/TESTPROG.PGM")
public class DummyRpcEntity implements RpcEntity {

	@RpcField(size = 8, direction = Direction.IN)
	private String name;
}
