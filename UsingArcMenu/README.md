#ArcMenu & RayMenu
##ArcMenu

This is a demostration app to show how to use the ArcMenu Library by **Capricorn**.

[Link to library on Github](https://github.com/daCapricorn/ArcMenu) 

An android custom view which looks like the menu in [Path 2.0](https://path.com/)

![Preview](https://dl.dropbox.com/u/11369687/preview0.png)
![Preview](https://dl.dropbox.com/u/11369687/preview1.png)

##RayMenu
![Preview](https://dl.dropbox.com/u/11369687/raymenu.png)
##About

The user experience in [Path 2.0](https://path.com/) (for iOS) is amazing, but the android version miss much.

Just for fun, I try to realize the amazing menu for android, which could be equal to the iOS version's.

##Usage

+ Import `library` module.

+ Setup the menu:

``` java
ArcMenu menu = (ArcMenu) findViewById(R.id.arc_menu);

final int itemCount = ITEM_DRAWABLES.length;
for (int i = 0; i < itemCount; i++) {
	ImageView item = new ImageView(this);
	item.setImageResource(ITEM_DRAWABLES[i]);

	final int position = i;
	menu.addItem(item, new OnClickListener() {

		@Override
		public void onClick(View v) {
			Toast.makeText(MainActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
		}
	});// Add a menu item
}
```

If you want to change the default appearence for ArcMenu:

in **arc_menu.xml**

    custom:childSize="50px"
    custom:fromDegrees="0.0"
    custom:toDegrees="300.0"

or in **ArcMenu.java**

``` java    
arcLayout.setChildSize(50);
arcLayout.setArc(0.0f, 300.0f);    
```
##Author

**Capricorn**

All copyrights to the library belong to **Capricorn**.

