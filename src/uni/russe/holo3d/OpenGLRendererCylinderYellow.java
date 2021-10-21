package uni.ruse.holo3d;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLU;
import android.opengl.GLSurfaceView.Renderer;

public class OpenGLRendererCylinderYellow implements Renderer {

	private Cylinder mCylinder = new Cylinder();
	private float mCylinderRotation;

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);

		gl.glClearDepthf(1.0f);
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glDepthFunc(GL10.GL_LEQUAL);

		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);

	}

	@Override
	public void onDrawFrame(GL10 gl) {
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		// Replace the current matrix with the identity matrix
		gl.glLoadIdentity();
		gl.glLineWidth(1.5f);
		gl.glColor4f(1.0f, 1.0f, 0.0f, 1.0f);// yellow
		// top
		gl.glTranslatef(0.0f, 2.0f, -10.0f);
		gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
		gl.glRotatef(mCylinderRotation, 0.0f, 0.0f, 1.0f);
		mCylinder.draw(gl);
		gl.glLoadIdentity();

		// left
		gl.glTranslatef(-2.0f, 0.0f, -10.0f);
		gl.glRotatef(90, 0.0f, 0.0f, 1.0f);
		gl.glRotatef(mCylinderRotation, 1.0f, 0.0f, 0.0f);
		mCylinder.draw(gl);
		gl.glLoadIdentity();

		// right
		gl.glTranslatef(2.0f, 0.0f, -10.0f);
		gl.glRotatef(90, 0.0f, 0.0f, 1.0f);
		gl.glRotatef(-mCylinderRotation, 1.0f, 0.0f, 0.0f);
		mCylinder.draw(gl);
		gl.glLoadIdentity();

		// bottom
		gl.glTranslatef(0.0f, -2.0f, -10.0f);
		gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
		gl.glRotatef(-mCylinderRotation, 0.0f, 0.0f, 1.0f);
		mCylinder.draw(gl);
		gl.glLoadIdentity();

		mCylinderRotation -= 0.25f;
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();

		float fovy = 50.0f; // Field of view angle, in degrees, in the Y
							// direction.
		float aspect = (float) width / (float) height;
		float zNear = 0.1f;
		float zFar = 100.0f;
		// Set up a perspective projection matrix
		GLU.gluPerspective(gl, fovy, aspect, zNear, zFar);

		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
	}
}