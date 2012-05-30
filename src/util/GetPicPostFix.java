package util;

public class GetPicPostFix {
	public static String getFilePostFix(String filename) {
		int index = 0;
		if (filename.toLowerCase().indexOf(".jpg") > 0) {
			index = filename.toLowerCase().indexOf(".jpg");
		} else if (filename.toLowerCase().indexOf(".jpeg") > 0) {
			index = filename.toLowerCase().indexOf(".jpeg");
		} else if (filename.toLowerCase().indexOf(".gif") > 0) {
			index = filename.toLowerCase().indexOf(".gif");
		} else if (filename.toLowerCase().indexOf(".png") > 0) {
			index = filename.toLowerCase().indexOf(".png");
		}
		return filename.substring(index);
	}

	public static void main(String[] args) {
		String a = "sdfads.JpeG";
		System.out.println(GetPicPostFix.getFilePostFix(a));
	}
}