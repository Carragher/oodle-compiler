/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class TUnknownChar extends Token
{
    public TUnknownChar(String text)
    {
        setText(text);
    }

    public TUnknownChar(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TUnknownChar(getText(), getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTUnknownChar(this);
    }
}
