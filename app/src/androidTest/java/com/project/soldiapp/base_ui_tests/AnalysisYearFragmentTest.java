package com.project.soldiapp.base_ui_tests;


import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.project.soldiapp.MainActivity;
import com.project.soldiapp.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AnalysisYearFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    Activity activity;

    @Before
    public void reachFragment(){
        activity = mActivityTestRule.getActivity();

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription(activity.getString(R.string.navigation_drawer_open)),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction navigationMenuItemView = onView(
                allOf(withText(mActivityTestRule.getActivity().getString(R.string.analysis)),
                        isDisplayed()));
        navigationMenuItemView.perform(click());

        ViewInteraction tabView = onView(
                allOf(withContentDescription(activity.getString(R.string.year)),
                        isDisplayed()));
        tabView.perform(click());
    }

    @Test
    public void testNavDrawer(){
        ViewInteraction imageButton = onView(
                allOf(withContentDescription(activity.getString(R.string.navigation_drawer_open)),
                        isDisplayed()));
        imageButton.check(matches(isDisplayed()));
    }

    @Test
    public void testToolbarTitle(){
        ViewInteraction textView = onView(
                allOf(withText(activity.getString(R.string.analysis)),
                        isDisplayed()));
        textView.check(matches(withText(activity.getString(R.string.analysis))));
    }

    @Test
    public void testTabMonth(){
        ViewInteraction actionBar$Tab = onView(
                allOf(withContentDescription(activity.getString(R.string.month)),
                        isDisplayed()));
        actionBar$Tab.check(matches(isDisplayed()));
    }

    @Test
    public void testTabYear(){
        ViewInteraction actionBar$Tab2 = onView(
                allOf(withContentDescription(activity.getString(R.string.year)),
                        isDisplayed()));
        actionBar$Tab2.check(matches(isDisplayed()));
    }

    @Test
    public void testTitleYearExpenses(){
        ViewInteraction textView2 = onView(
                allOf(withId(R.id.titleYearTab), withText(activity.getString(R.string.yearTitle)),
                        isDisplayed()));
        textView2.check(matches(withText(activity.getString(R.string.yearTitle))));
    }

    @Test
    public void testSpinnerYear(){
        ViewInteraction spinner = onView(
                allOf(withId(R.id.spinnerYear),
                        isDisplayed()));
        spinner.check(matches(isDisplayed()));
    }

    @Test
    public void testTextTotalExpenses(){
        ViewInteraction textView3 = onView(
                allOf(withId(R.id.totalText), withText(activity.getString(R.string.total)),
                        isDisplayed()));
        textView3.check(matches(withText(activity.getString(R.string.total))));
    }

    @Test
    public void testTotalExpenseText(){

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.textTotalExpenseYear), withText(containsString("€")),
                        isDisplayed()));
        textView4.check(matches(withText(containsString("€"))));
    }

    @Test
    public void testLineChartTitle(){
        ViewInteraction textView5 = onView(
                allOf(withId(R.id.titleLineChartYear),
                        isDisplayed()));
        textView5.check(matches(isDisplayed()));
    }

    @Test
    public void testLineChart(){
        ViewInteraction viewGroup2 = onView(
                allOf(withId(R.id.lineYearChart),
                        isDisplayed()));
        viewGroup2.check(matches(isDisplayed()));
    }

    @Test
    public void testXAxisTitle(){
        onView(withId(R.id.xAxisTitleYear))
                .perform(scrollTo());

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.xAxisTitleYear),withText(activity.getString(R.string.months)),
                        isDisplayed()));
        textView6.check(matches(withText(activity.getString(R.string.months))));

    }

    @Test
    public void testTitleTypeChart(){
        onView(withId(R.id.titleTypeChartYear))
                .perform(scrollTo());

        ViewInteraction textView7 = onView(
                allOf(withId(R.id.titleTypeChartYear), withText(activity.getString(R.string.typeChartTitle)),
                        isDisplayed()));
        textView7.check(matches(withText(activity.getString(R.string.typeChartTitle))));
    }

    @Test
    public void testPieChartType(){
        onView(withId(R.id.expensesYearTypeChart))
                .perform(scrollTo());

        ViewInteraction viewGroup4 = onView(
                allOf(withId(R.id.expensesYearTypeChart),
                        isDisplayed()));
        viewGroup4.check(matches(isDisplayed()));
    }

    @Test
    public void testLegendSupermarketPair(){
        onView(withId(R.id.supermarketYearLegend))
                .perform(scrollTo());

        ViewInteraction imageView = onView(
                allOf(withId(R.id.supermarketYearLegend),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));

        ViewInteraction textView8 = onView(
                allOf(withId(R.id.YearExpenseSupermarket), withText(containsString("€")),
                        isDisplayed()));
        textView8.check(matches(withText(containsString("€"))));
    }

    @Test
    public void testLegendShoppingPair(){

        onView(withId(R.id.shoppingYearLegend))
                .perform(scrollTo());

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.shoppingYearLegend),
                        isDisplayed()));
        imageView2.check(matches(isDisplayed()));

        ViewInteraction textView9 = onView(
                allOf(withId(R.id.YearExpenseShopping), withText(containsString("€")),
                        isDisplayed()));
        textView9.check(matches(withText(containsString("€"))));
    }

    @Test
    public void testLegendTransportPair(){

        onView(withId(R.id.transportYearLegend))
                .perform(scrollTo());

        ViewInteraction imageView3 = onView(
                allOf(withId(R.id.transportYearLegend),
                        isDisplayed()));
        imageView3.check(matches(isDisplayed()));

        ViewInteraction textView10 = onView(
                allOf(withId(R.id.YearExpenseTransport), withText(containsString("€")),
                        isDisplayed()));
        textView10.check(matches(withText(containsString("€"))));
    }

    @Test
    public void testLegendBillsPair(){
        onView(withId(R.id.billsYearLegend))
                .perform(scrollTo());

        ViewInteraction imageView4 = onView(
                allOf(withId(R.id.billsYearLegend),
                        isDisplayed()));
        imageView4.check(matches(isDisplayed()));

        ViewInteraction textView11 = onView(
                allOf(withId(R.id.YearExpenseBills), withText(containsString("€")),
                        isDisplayed()));
        textView11.check(matches(withText(containsString("€"))));
    }

    @Test
    public void testLegendLeisurePair(){

        onView(withId(R.id.leisureYearLegend))
                .perform(scrollTo());

        ViewInteraction imageView5 = onView(
                allOf(withId(R.id.leisureYearLegend),
                        isDisplayed()));
        imageView5.check(matches(isDisplayed()));

        ViewInteraction textView12 = onView(
                allOf(withId(R.id.YearExpenseLeisure), withText(containsString("€")),
                        isDisplayed()));
        textView12.check(matches(withText(containsString("€"))));
    }

    @Test
    public void testLegendOtherPair(){
        onView(withId(R.id.otherYearLegend))
                .perform(scrollTo());

        ViewInteraction imageView6 = onView(
                allOf(withId(R.id.otherYearLegend),
                        isDisplayed()));
        imageView6.check(matches(isDisplayed()));

        ViewInteraction textView13 = onView(
                allOf(withId(R.id.YearExpenseOther), withText(containsString("€")),

                        isDisplayed()));
        textView13.check(matches(withText(containsString("€"))));
    }

    @Test
    public void testTitlePaymentChart(){
        onView(withId(R.id.titlePaymentChartYear))
                .perform(scrollTo());

        ViewInteraction textView14 = onView(
                allOf(withId(R.id.titlePaymentChartYear), withText(activity.getString(R.string.paymentChartTitle)),
                        isDisplayed()));
        textView14.check(matches(withText(activity.getString(R.string.paymentChartTitle))));
    }

    @Test
    public void testPieChartPayment(){
        onView(withId(R.id.expensesYearPaymentChart))
                .perform(scrollTo());

        ViewInteraction viewGroup6 = onView(
                allOf(withId(R.id.expensesYearPaymentChart),
                        isDisplayed()));
        viewGroup6.check(matches(isDisplayed()));
    }

    @Test
    public void testLegendCashPair(){
        onView(withId(R.id.cashYearLegend))
                .perform(scrollTo());

        ViewInteraction imageView8 = onView(
                allOf(withId(R.id.cashYearLegend),
                        isDisplayed()));
        imageView8.check(matches(isDisplayed()));

        ViewInteraction textView15 = onView(
                allOf(withId(R.id.YearExpenseCash), withText(containsString("€"))));
        textView15.check(matches(withText(containsString("€"))));
    }

    @Test
    public void testLegendCardPair(){
        onView(withId(R.id.cardYearLegend))
                .perform(scrollTo());

        ViewInteraction imageView9 = onView(
                allOf(withId(R.id.cardYearLegend),
                        isDisplayed()));
        imageView9.check(matches(isDisplayed()));

        ViewInteraction textView16 = onView(
                allOf(withId(R.id.YearExpenseCard), withText(containsString("€")),
                        isDisplayed()));
        textView16.check(matches(withText(containsString("€"))));
    }

}
