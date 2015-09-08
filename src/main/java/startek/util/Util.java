package startek.util;

import org.apache.commons.lang3.RandomStringUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Niwoogaba_Joel
 */
public class Util {

	public static final String BASE_URL = "/";
	public static final String T1_ = "t1_/";
	public static final String IMG_URL = "up_/users/";
	public static final String USER_CONTENT_BASE = "http://theweddingwolf.com/weddings_user_content/posts_/";
	public static final String ARTICLE_PREVIEWS = "http://www.theweddingwolf.com/tww/wedding-magazine/";
	public static final String POST_PREVIEWS ="http://www.theweddingwolf.com/your-wedding-directory/101wedding-item-details/";
	public static String metaRefreshHtml(String title, String url, String msg) {
		StringBuilder b = new StringBuilder();
		b.append("<html><head><title>");
		b.append(title);
		b.append("</title><META http-equiv='refresh' content='6;URL=");
		b.append(url);
		b.append("'> </head><body bgcolor='#ffffff'><center>");
		b.append(msg);
		b.append("<a href='");
		b.append(url);
		b.append("'>");
		b.append(url);
		b.append("</a>");
		b.append("</center></body></html>");
		return b.toString();
	}

	/**
	 * Represents image size of the system _s =Square, _x =Resized
	 * Automatically, _c=Cropped Size
	 * 
	 * @author kaylabz-pc
	 *
	 */
	public static final class ImageSize {
		public static final String _s100 = "_s100";
		public static final String _x100 = "_x100";
		public static final String _x200 = "_x200";
		public static final String _x300 = "_x300";
	}

	public static final class OldSkt {
		public static final String post_main_fld = "psts_";
		public static final String post_fld = "posts_";
		public static final String acc_fld = "acc_";
		public static final String thumb_x80 = "x80_";
		public static final String thumb_x490 = "x490_";
		public static final String thumb_x100 = "x100_";
		public static final String thumb_x285 = "x285_";
		public static final String thumb_x200 = "x200_";

		public static final String cropped_fld = "cr_";
		public static final String cthumb_x350 = "x350_";
		public static final String cthumb_x261 = "x261_";
		public static final String cthumb_x100 = "x100_";
		public static final String cthumb_x50 = "x50_";
		public static final String cthumb_x75 = "x75_";

	}

	// http://theweddingwolf.com/weddings_user_content/posts_/x490_/x490_2ZbiLcLhlUjrFuZoi8t01421857495771.jpg
	/**
	 * Create path to all the Images of The user
	 * 
	 * @Mode 0=Main Image
	 * @Mode 1=/x490_/x490_[imageName].jpg
	 * @Mode 2=/cr__/x490_[imageName].jpg
	 * @param folder
	 * @param size
	 * @param mode
	 * @return
	 */
	public static String imgLink(String size, int mode) {
		switch (mode) {
		case 0:
			return USER_CONTENT_BASE + OldSkt.post_main_fld + "/";
		case 1:
			return USER_CONTENT_BASE + size + "/" + size + "/" + size;
		case 2:
			return USER_CONTENT_BASE + OldSkt.cropped_fld + "/" + size;
		default:
			return "http://theweddingwolf.com/weddings_user_content/no-img-gallery.png";
		}

	}

	/**
	 * Create a Path to the account folder
	 * 
	 * @Mode 0=Main Account Image
	 * @Mode 1=/acc_/x490_[imageName].jpg
	 * @Mode 2=/cr_/x490_[imageName].jpg
	 * @param folder
	 * @param size
	 * @param mode
	 * @return
	 */
	public static String imgAcc(String size, int mode) {
		switch (mode) {
		case 0:
			return USER_CONTENT_BASE + OldSkt.acc_fld + "/";
		case 1:
			return USER_CONTENT_BASE + OldSkt.acc_fld + "/" + size;
		case 2:
			return USER_CONTENT_BASE + OldSkt.acc_fld + "/"
					+ OldSkt.cropped_fld + "/" + size;
		default:
			return "http://theweddingwolf.com/weddings_user_content/no-img-gallery.png";
		}

	}

	// relationship/18/-5-reasons-every-couple-should-have-sex-before-marriage/
	public static String createPreview(String cateogry, Long id,
			String description) {
		String link = null;

		return link;
	}

	public static String cleanUrl(String args) {
		args = (args == null || "".equals(args)) ? "Uganda Weddings,Uganda Service Providers"
				: args;
		return (args.replace(" &", "")).replace("!", "").replace("%", "")
				.replace("^", "").replace(" ", "-").replace(",", "-")
				.replace("#", "").replace("'", "").replace("#", "").replace("=", "").toLowerCase();
	}

	public static String fullName(String firstName, String lastName) {
		return firstName.replace(" ", "_") + "_"
				+ lastName.replace(" ", "_").toLowerCase();
	}

	public static String randomize(int size) {
		return RandomStringUtils.randomAlphanumeric(size);

	}

}
