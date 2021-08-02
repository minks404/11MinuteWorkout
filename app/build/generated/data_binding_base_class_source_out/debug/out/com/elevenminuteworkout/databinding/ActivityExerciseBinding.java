// Generated by view binder compiler. Do not edit!
package com.elevenminuteworkout.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.elevenminuteworkout.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityExerciseBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageView ivImage;

  @NonNull
  public final LinearLayout llExerciseView;

  @NonNull
  public final LinearLayout llRestView;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final ProgressBar progressBarExercise;

  @NonNull
  public final RecyclerView rvExerciseStatus;

  @NonNull
  public final Toolbar toolbarExerciseActivity;

  @NonNull
  public final TextView tvExerciseName;

  @NonNull
  public final TextView tvExerciseTimer;

  @NonNull
  public final TextView tvTimer;

  @NonNull
  public final TextView tvUpcomingExerciseName;

  private ActivityExerciseBinding(@NonNull RelativeLayout rootView, @NonNull ImageView ivImage,
      @NonNull LinearLayout llExerciseView, @NonNull LinearLayout llRestView,
      @NonNull ProgressBar progressBar, @NonNull ProgressBar progressBarExercise,
      @NonNull RecyclerView rvExerciseStatus, @NonNull Toolbar toolbarExerciseActivity,
      @NonNull TextView tvExerciseName, @NonNull TextView tvExerciseTimer,
      @NonNull TextView tvTimer, @NonNull TextView tvUpcomingExerciseName) {
    this.rootView = rootView;
    this.ivImage = ivImage;
    this.llExerciseView = llExerciseView;
    this.llRestView = llRestView;
    this.progressBar = progressBar;
    this.progressBarExercise = progressBarExercise;
    this.rvExerciseStatus = rvExerciseStatus;
    this.toolbarExerciseActivity = toolbarExerciseActivity;
    this.tvExerciseName = tvExerciseName;
    this.tvExerciseTimer = tvExerciseTimer;
    this.tvTimer = tvTimer;
    this.tvUpcomingExerciseName = tvUpcomingExerciseName;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityExerciseBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityExerciseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_exercise, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityExerciseBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ivImage;
      ImageView ivImage = rootView.findViewById(id);
      if (ivImage == null) {
        break missingId;
      }

      id = R.id.llExerciseView;
      LinearLayout llExerciseView = rootView.findViewById(id);
      if (llExerciseView == null) {
        break missingId;
      }

      id = R.id.llRestView;
      LinearLayout llRestView = rootView.findViewById(id);
      if (llRestView == null) {
        break missingId;
      }

      id = R.id.progressBar;
      ProgressBar progressBar = rootView.findViewById(id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.progressBarExercise;
      ProgressBar progressBarExercise = rootView.findViewById(id);
      if (progressBarExercise == null) {
        break missingId;
      }

      id = R.id.rvExerciseStatus;
      RecyclerView rvExerciseStatus = rootView.findViewById(id);
      if (rvExerciseStatus == null) {
        break missingId;
      }

      id = R.id.toolbar_exercise_activity;
      Toolbar toolbarExerciseActivity = rootView.findViewById(id);
      if (toolbarExerciseActivity == null) {
        break missingId;
      }

      id = R.id.tvExerciseName;
      TextView tvExerciseName = rootView.findViewById(id);
      if (tvExerciseName == null) {
        break missingId;
      }

      id = R.id.tvExerciseTimer;
      TextView tvExerciseTimer = rootView.findViewById(id);
      if (tvExerciseTimer == null) {
        break missingId;
      }

      id = R.id.tvTimer;
      TextView tvTimer = rootView.findViewById(id);
      if (tvTimer == null) {
        break missingId;
      }

      id = R.id.tvUpcomingExerciseName;
      TextView tvUpcomingExerciseName = rootView.findViewById(id);
      if (tvUpcomingExerciseName == null) {
        break missingId;
      }

      return new ActivityExerciseBinding((RelativeLayout) rootView, ivImage, llExerciseView,
          llRestView, progressBar, progressBarExercise, rvExerciseStatus, toolbarExerciseActivity,
          tvExerciseName, tvExerciseTimer, tvTimer, tvUpcomingExerciseName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}