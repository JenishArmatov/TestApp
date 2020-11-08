<?xml version="1.0"?>

<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
                xmlns:tools="http://schemas.android.com/tools"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_gravity="top|center_horizontal"
                android:background="#000000"
                tools:context=".ui.activities.QCircleActivity">

    <RelativeLayout
        android:id="@+id/cover_main_view"
        android:layout_width="@dimen/physical_width_of_quickcircle"
        android:layout_height="@dimen/physical_height_of_quickcircle"
        android:layout_gravity="center_horizontal">

        <TextView
            android:id="@+id/text1"
            style="?attr/secondaryTextViewStyle"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_centerHorizontal="true"
            android:layout_marginTop="64dp"
            android:fontFamily="sans-serif-light"
            android:gravity="center"
            android:maxLines="1"
            android:paddingLeft="64dp"
            android:paddingRight="64dp" />

        <TextView
            android:id="@+id/text2"
            style="?android:textAppearanceLarge"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_below="@id/text1"
            android:layout_centerHorizontal="true"
            android:layout_marginTop="8dp"
            android:fontFamily="sans-serif-light"
            android:gravity="center"
            android:maxLines="1"
            android:paddingLeft="48dp"
            android:paddingRight="48dp"
            android:textColor="@color/primary_text_dark"/>

        <ImageButton
            android:id="@+id/btn_prev"
            android:layout_width="40dp"
            android:layout_height="40dp"
            android:layout_alignParentLeft="true"
            android:layout_below="@id/text2"
            android:layout_centerHorizontal="true"
            android:layout_marginLeft="48dp"
            android:layout_marginTop="20dp"
            android:background="@android:color/transparent"
            android:src="@drawable/ic_prev_white"/>

        <ImageButton
            android:id="@+id/btn_pause"
            android:layout_width="48dp"
            android:layout_height="48dp"
            android:layout_below="@id/text2"
            android:layout_centerHorizontal="true"
            android:layout_marginRight="30dp"
            android:layout_marginTop="16dp"
            android:background="@android:color/transparent"
            android:src="@drawable/ic_pause_white"/>

        <ImageButton
            android:id="@+id/btn_skip"
            android:layout_width="40dp"
            android:layout_height="40dp"
            android:layout_alignParentRight="true"
            android:layout_below="@id/text2"
            android:layout_centerHorizontal="true"
            android:layout_marginRight="48dp"
            android:layout_marginTop="20dp"
            android:background="@android:color/transparent"
            android:src="@drawable/ic_skip_white"/>

        <ImageButton
            android:id="@+id/back_btn"
            android:layout_width="43dp"
            android:layout_height="23dp"
            android:layout_alignParentBottom="true"
            android:layout_centerHorizontal="true"
            android:layout_marginBottom="40dp"
            android:background="@android:color/transparent"
            android:src="@drawable/backbutton"/>

    </RelativeLayout>

</RelativeLayout>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             