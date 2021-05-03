# CollapsingToolBar
various Collapsing ToolBar Layout And properties explored

1. ScrollFlags
There are 5 scrollflags provided, these are
scroll, expandAlways, expandAlwaysCollapsed, snap, exitUntilCollapsed.
In order to use scrollflags in your CollapsingToolbar add the following property to your CollapsingToolbar.

app:layout_scrollFlags=”select-flag-here(Can be a combination of flags)” 

 app:layout_scrollFlags="noScroll"

      The view will be scroll in direct relation to scroll events. This flag needs to be
           set for any of the other flags to take effect. If any sibling views
           before this one do not have this flag, then this value has no effect.
           
      app:layout_scrollFlags="scroll"

      When exiting (scrolling off screen) the view will be scrolled until it is
           'collapsed'. The collapsed height is defined by the view's minimum height.
           
      app:layout_scrollFlags="exitUntilCollapsed"

      When entering (scrolling on screen) the view will scroll on any downwards
           scroll event, regardless of whether the scrolling view is also scrolling. This
           is commonly referred to as the 'quick return' pattern.
           
      app:layout_scrollFlags="enterAlways"

     An additional flag for 'enterAlways' which modifies the returning view to
           only initially scroll back to it's collapsed height. Once the scrolling view has
           reached the end of it's scroll range, the remainder of this view will be scrolled
           into view.
           
      app:layout_scrollFlags="enterAlwaysCollapsed"

     Upon a scroll ending, if the view is only partially visible then it will be
           snapped and scrolled to it's closest edge.
           
      app:layout_scrollFlags="snap"

     An additional flag to be used with 'snap'. If set, the view will be snapped to its
           top and bottom margins, as opposed to the edges of the view itself.
      app:layout_scrollFlags="snapMargins"

For more about different scroll flags.Link:- https://medium.com/martinomburajr/android-design-collapsing-toolbar-scrollflags-e1d8a05dcb02
