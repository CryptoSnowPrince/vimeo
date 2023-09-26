# vimeo

Required Dev Tools: 
	Node 16.20
	jdk-17.0.7
	android-studio-2022.2.1.20
	add ENV variables:
	ANDROID_HOME=C:/Users/%USERNAME%/AppData/Local/Android/Sdk

How to configure project: 
	npm install

How to build and test a project:
	[run Android Studio and its Emulator]
	npm start android
	[press a]

Generated File path: ./android/app/build/outputs/apk/debug/app-debug.apk

How to build a release binary:
	./android/gradlew assembleRelease

Release path: ./android/app/build/outputs/apk/release/app-release.apk

How to add analytics and crashlytics:
	1. Visit and sign up to https://console.firebase.google.com
	2. Create project.
	3. Add application name by "com.vimeo"
	4. Download google-services.json and add into ./android/app
	5. Append to android/build.gradle
        repositories {
        	google()
        	mavenCentral()
		}
		dependencies {
			classpath("com.android.tools.build:gradle")
			classpath("com.facebook.react:react-native-gradle-plugin")
			classpath('com.google.gms:google-services:4.3.8')
			classpath('com.google.firebase:firebase-crashlytics-gradle:2.9.6')
		}
  	6. Append to app/build.gradle
		dependencies {
			implementation('com.google.gms:google-services:4.3.8')
			implementation('com.google.firebase:firebase-analytics:20.0.0')
			implementation(platform("com.google.firebase:firebase-bom:32.1.1"))
			implementation("com.google.firebase:firebase-crashlytics:2.9.6")
		}
		...
        apply plugin: "com.google.gms.google-services"
		apply plugin: "com.google.firebase.crashlytics"
  	7. Modify onCreate() function in MainApplication.java
		super.onCreate();
		try{
			...
			FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
			mFirebaseAnalytics.logEvent("on_create", null);
			ReactNativeFlipper.initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
		}
		catch(Exception e){
			throw new RuntimeException("Test Crash"); 
		}

How to add AdMov:
	1. Visit and sign up to admob.google.com
	2. Create ads and get Unit ID
	3. Insert into AndroidManifest.xml
		<application> ...
			<meta-data
				android:name="com.google.android.gms.ads.APPLICATION_ID"
				android:value="app ID"/>
	4. Insert into build.gradle
		implementation 'com.google.android.gms:play-services-ads:22.2.0'
	5. Create Ads Page with Java and link with ReactActivity
