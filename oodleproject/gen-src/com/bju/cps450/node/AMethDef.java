/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import java.util.*;
import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class AMethDef extends PMethDef
{
    private PMethType _methType_;
    private TId _begin_;
    private final LinkedList<PArgument> _argument_ = new LinkedList<PArgument>();
    private final LinkedList<PVarDec> _varDec_ = new LinkedList<PVarDec>();
    private final LinkedList<PStatement> _statement_ = new LinkedList<PStatement>();
    private TId _end_;

    public AMethDef()
    {
        // Constructor
    }

    public AMethDef(
        @SuppressWarnings("hiding") PMethType _methType_,
        @SuppressWarnings("hiding") TId _begin_,
        @SuppressWarnings("hiding") List<?> _argument_,
        @SuppressWarnings("hiding") List<?> _varDec_,
        @SuppressWarnings("hiding") List<?> _statement_,
        @SuppressWarnings("hiding") TId _end_)
    {
        // Constructor
        setMethType(_methType_);

        setBegin(_begin_);

        setArgument(_argument_);

        setVarDec(_varDec_);

        setStatement(_statement_);

        setEnd(_end_);

    }

    @Override
    public Object clone()
    {
        return new AMethDef(
            cloneNode(this._methType_),
            cloneNode(this._begin_),
            cloneList(this._argument_),
            cloneList(this._varDec_),
            cloneList(this._statement_),
            cloneNode(this._end_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMethDef(this);
    }

    public PMethType getMethType()
    {
        return this._methType_;
    }

    public void setMethType(PMethType node)
    {
        if(this._methType_ != null)
        {
            this._methType_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._methType_ = node;
    }

    public TId getBegin()
    {
        return this._begin_;
    }

    public void setBegin(TId node)
    {
        if(this._begin_ != null)
        {
            this._begin_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._begin_ = node;
    }

    public LinkedList<PArgument> getArgument()
    {
        return this._argument_;
    }

    public void setArgument(List<?> list)
    {
        for(PArgument e : this._argument_)
        {
            e.parent(null);
        }
        this._argument_.clear();

        for(Object obj_e : list)
        {
            PArgument e = (PArgument) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._argument_.add(e);
        }
    }

    public LinkedList<PVarDec> getVarDec()
    {
        return this._varDec_;
    }

    public void setVarDec(List<?> list)
    {
        for(PVarDec e : this._varDec_)
        {
            e.parent(null);
        }
        this._varDec_.clear();

        for(Object obj_e : list)
        {
            PVarDec e = (PVarDec) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._varDec_.add(e);
        }
    }

    public LinkedList<PStatement> getStatement()
    {
        return this._statement_;
    }

    public void setStatement(List<?> list)
    {
        for(PStatement e : this._statement_)
        {
            e.parent(null);
        }
        this._statement_.clear();

        for(Object obj_e : list)
        {
            PStatement e = (PStatement) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._statement_.add(e);
        }
    }

    public TId getEnd()
    {
        return this._end_;
    }

    public void setEnd(TId node)
    {
        if(this._end_ != null)
        {
            this._end_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._end_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._methType_)
            + toString(this._begin_)
            + toString(this._argument_)
            + toString(this._varDec_)
            + toString(this._statement_)
            + toString(this._end_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._methType_ == child)
        {
            this._methType_ = null;
            return;
        }

        if(this._begin_ == child)
        {
            this._begin_ = null;
            return;
        }

        if(this._argument_.remove(child))
        {
            return;
        }

        if(this._varDec_.remove(child))
        {
            return;
        }

        if(this._statement_.remove(child))
        {
            return;
        }

        if(this._end_ == child)
        {
            this._end_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._methType_ == oldChild)
        {
            setMethType((PMethType) newChild);
            return;
        }

        if(this._begin_ == oldChild)
        {
            setBegin((TId) newChild);
            return;
        }

        for(ListIterator<PArgument> i = this._argument_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PArgument) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        for(ListIterator<PVarDec> i = this._varDec_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PVarDec) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        for(ListIterator<PStatement> i = this._statement_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PStatement) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._end_ == oldChild)
        {
            setEnd((TId) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
