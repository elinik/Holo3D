package uni.ruse.holo3d;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;
//draw cube
public class Cube {

	private FloatBuffer mVertexBuffer;
	private ByteBuffer mIndexBuffer;
   
	private float vertices[] = {
			-1.0f, -1.0f, -1.0f, 
			0.0f, -1.0f, -1.0f, 
			0.0f,0.0f, -1.0f, 
			-1.0f, 0.0f, -1.0f, 
			-1.0f, -1.0f, 0.0f,
			0.0f, -1.0f,0.0f, 
			0.0f, 0.0f, 0.0f, 
			-1.0f, 0.0f, 0.0f };

	private byte indices[] = { 
			0, 1, 1, 5, 5, 4, 4, 0,// bottom
			0, 3, 3, 7, 7, 4,// left
			4, 5, 5, 6, 6, 7,// front
			7, 6, 6, 2, 2, 1,// right
			1, 2, 2, 3 };

	public Cube() {

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
		// Enable vertex array buffer to be used during rendering
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		// Tell openGL where the vertex array buffer is
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mVertexBuffer);
		// Draw each plane, based on the mIndexBuffer information
		gl.glDrawElements(GL10.GL_LINES, indices.length, GL10.GL_UNSIGNED_BYTE,
				mIndexBuffer);
		// Disable vertex array buffer after used rendering
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	}		  
}
	
