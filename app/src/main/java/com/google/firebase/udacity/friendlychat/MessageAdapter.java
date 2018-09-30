package com.google.firebase.udacity.friendlychat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static com.google.firebase.udacity.friendlychat.MainActivity.current;

public class MessageAdapter extends ArrayAdapter<FriendlyMessage> {
  //  static String current;
    List<FriendlyMessage> list=new ArrayList<FriendlyMessage>();
   public void add(FriendlyMessage friendlyMessage)
    {
        this.list.add(friendlyMessage);
        notifyDataSetChanged();
    }
    public MessageAdapter(Context context, int resource, List<FriendlyMessage> objects) {

        super(context, resource, objects);
        list=objects;


    }

    @SuppressLint("ResourceType")
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        FriendlyMessage object = list.get(position);

     //   Toast.makeText(, current, Toast.LENGTH_SHORT).show();

        if (MainActivity.current.equals(object.getName())) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.send, parent, false);

            //  convertView.setBackgroundResource(R.drawable.send_draw);
            //   ImageView photoImageView = (ImageView) convertView.findViewById(R.id.photoImageView);
            TextView messageTextView = (TextView) convertView.findViewById(R.id.messagebody);
            TextView authorTextView = (TextView) convertView.findViewById(R.id.name);
            // TextView time=(TextView) convertView.findViewById(R.id.text_message_time);


            FriendlyMessage message = getItem(position);

            boolean isPhoto = message.getPhotoUrl() != null;
            if (isPhoto) {
                messageTextView.setVisibility(View.GONE);
                //   photoImageView.setVisibility(View.VISIBLE);
                //   Glide.with(photoImageView.getContext())
                //          .load(message.getPhotoUrl())
                //        .into(photoImageView);
            } else {
                messageTextView.setVisibility(View.VISIBLE);
                //  photoImageView.setVisibility(View.GONE);
                messageTextView.setText(message.getText());
            }
            authorTextView.setText(message.getName());
        }
        else
        {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.xyz, parent, false);

            //  convertView.setBackgroundResource(R.drawable.send_draw);
            //   ImageView photoImageView = (ImageView) convertView.findViewById(R.id.photoImageView);
            TextView messageTextView = (TextView) convertView.findViewById(R.id.msgbody);
            TextView authorTextView = (TextView) convertView.findViewById(R.id.msgname);
            // TextView time=(TextView) convertView.findViewById(R.id.text_message_time);


            FriendlyMessage message = getItem(position);

            boolean isPhoto = message.getPhotoUrl() != null;
            if (isPhoto) {
                messageTextView.setVisibility(View.GONE);
                //   photoImageView.setVisibility(View.VISIBLE);
                //   Glide.with(photoImageView.getContext())
                //          .load(message.getPhotoUrl())
                //        .into(photoImageView);
            } else {
                messageTextView.setVisibility(View.VISIBLE);
                //  photoImageView.setVisibility(View.GONE);
                messageTextView.setText(message.getText());
            }
            authorTextView.setText(message.getName());
        }

        return convertView;
    }

}
