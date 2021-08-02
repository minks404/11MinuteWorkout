// Generated by view binder compiler. Do not edit!
package com.elevenminuteworkout.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.elevenminuteworkout.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout container;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final LinearLayout login;

  @NonNull
  public final EditText name;

  @NonNull
  public final EditText password;

  @NonNull
  public final LinearLayout register;

  private ActivityLoginBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout container, @NonNull ImageView imageView,
      @NonNull LinearLayout login, @NonNull EditText name, @NonNull EditText password,
      @NonNull LinearLayout register) {
    this.rootView = rootView;
    this.container = container;
    this.imageView = imageView;
    this.login = login;
    this.name = name;
    this.password = password;
    this.register = register;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout container = (ConstraintLayout) rootView;

      id = R.id.imageView;
      ImageView imageView = rootView.findViewById(id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.login;
      LinearLayout login = rootView.findViewById(id);
      if (login == null) {
        break missingId;
      }

      id = R.id.name;
      EditText name = rootView.findViewById(id);
      if (name == null) {
        break missingId;
      }

      id = R.id.password;
      EditText password = rootView.findViewById(id);
      if (password == null) {
        break missingId;
      }

      id = R.id.register;
      LinearLayout register = rootView.findViewById(id);
      if (register == null) {
        break missingId;
      }

      return new ActivityLoginBinding((ConstraintLayout) rootView, container, imageView, login,
          name, password, register);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
