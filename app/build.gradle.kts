plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.conectamovilb"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.conectamovilb"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation (platform("com.google.firebase:firebase-bom:30.3.1"))

    implementation ("com.google.firebase:firebase-analytics")
    implementation ("com.google.firebase:firebase-database")
    implementation ("com.google.firebase:firebase-auth-ktx")

    implementation ("org.eclipse.paho:org.eclipse.paho.client.mqttv3:1.2.5")
    implementation ("org.eclipse.paho:org.eclipse.paho.android.service:1.1.1")



    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")



    implementation ("androidx.recyclerview:recyclerview:1.2.1")
    implementation ("androidx.cardview:cardview:1.0.0")

    implementation ("com.google.firebase:firebase-database:10.2.6")
    implementation ("com.google.firebase:firebase-storage:10.2.6")

    implementation ("de.hdodenhof:circleimageview:1.3.0")
    implementation ("com.github.bumptech.glide:glide:3.7.0")

}