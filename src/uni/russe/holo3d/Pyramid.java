package uni.ruse.holo3d;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

//draw pyramid
public class Pyramid {
	private FloatBuffer mVertexBuffer;

	private ByteBuffer mIndexBuffer;

	private float vertices[] = { 0.0f, 0.5f, 0.0f,// v
			-1.0f, -1.0f, -1.0f,// 1
			1.0f, -1.0f, -1.0f,// 2
			1.0f, -1.0f, 1.0f,// 3
			-1.0f, -1.0f, 1.0f // 4
	};

	private byte indices[] = { 0, 1, 1, 2, 2, 0, 0, 3, 3, 2, 2, 3, 3, 4, 4, 0,
			0, 1, 1, 4 };

	public Pyramid() {
		ByteBuffer byteBuf = ByteBuffer.allocateDirect(vertices.length * 4);
		byteBuf.order(ByteOrder.nativeOrder());
		mVertexBuffer = byteBuf.asFloatBuffer();
		mVertexBuffer.put(vertices);
		mVertexBuffer.position(0);

		mIndexBuffer = ByteBuffer.allocateDirect(indices.length);
		mIndexBuffer.put(indices);
		mIndexBuffer.position(0);
	}

	public void draw(GL10 gl) {
		gl.glFrontFace(GL10.GL_CW);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mVertexBuffer);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDrawElements(GL10.GL_LINES, 20, GL10.GL_UNSIGNED_BYTE,
				mIndexBuffer);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

	}

}