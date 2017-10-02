package com.drcdadaab.dhaqanuser;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by oriaso on 9/25/17.
 */

public class ArticleViewHolder extends RecyclerView.ViewHolder {
    TextView textViewListArticleTitle, textViewListArticleCategory, textViewListArticleAuthor;
    View mView;

    public ArticleViewHolder(View itemView){
        super(itemView);
        this.mView = itemView;
        textViewListArticleTitle = (TextView) itemView.findViewById(R.id.textViewListArticleTitle);
//        textViewListArticleCategory = (TextView) itemView.findViewById(R.id.textViewListArticleCategory);
        textViewListArticleAuthor = (TextView) itemView.findViewById(R.id.textViewListArticleAuthor);
    }

}