package main.com.FriendHub.Utilities;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;

public class ProfilePicture {
	public String getProfilePictureByteArray(Blob profilePicture) {
		String base64Encoded = "";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		Blob blob = profilePicture;
		InputStream in = null;
		if (blob != null) {
		try {
			in = blob.getBinaryStream();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("id content" + in);
		int n = 0;
		try {
			while ((n = in.read(buf)) >= 0) {
				baos.write(buf, 0, n);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] bytes = baos.toByteArray();
		System.out.println("bytes" + bytes);
		// byte[] encodeBase64 = Base64.encodeBase64(buf);
		try {
			base64Encoded = new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return "data:image/jpeg;base64," + base64Encoded;
	}
}
